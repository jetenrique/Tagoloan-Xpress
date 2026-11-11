const assetPathPrefix = "https://www.figma.com/api/mcp/asset/3c95ebe0-8e09-49e9-a3b2-4a92e0fc7928";
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgIconBack = `${assetPathPrefix}/82c1c.svg`;
const imgIconCheck = `${assetPathPrefix}/cd8ea.svg`;
const imgIconCheck1 = `${assetPathPrefix}/a83fa.svg`;
const imgIconArrow = `${assetPathPrefix}/76d20.svg`;

export default function RiderApproval() {
  return (
    <div className="bg-[#fbf9f1] relative size-full" data-node-id="3:1809" data-name="rider approval">
      <div className="absolute bg-[#fbf9f1] content-stretch flex flex-col h-[844px] items-start left-0 overflow-clip top-0 w-[390px]" data-node-id="130:75" data-name="Screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="130:76" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="130:77" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="130:78">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="130:79" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="130:80" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="130:82" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="130:84" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex gap-[12px] items-center overflow-clip px-[16px] py-[8px] relative shrink-0 w-full" data-node-id="130:86" data-name="App bar">
          <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex items-center justify-center overflow-clip relative rounded-[20px] shrink-0 size-[40px]" data-node-id="130:87" data-name="Back button">
            <div className="relative shrink-0 size-[18px]" data-node-id="130:88" data-name="icon/back">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBack} />
            </div>
          </a>
          <div className="content-stretch flex flex-[1_0_0] flex-col items-start min-w-px overflow-clip relative" data-node-id="130:90" data-name="Container">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] relative shrink-0 text-[#18181f] text-[18px] w-full" data-node-id="130:91">
              Application approved
            </p>
          </div>
        </div>
        <div className="content-stretch flex flex-[1_0_0] flex-col gap-[16px] items-start min-h-px overflow-clip px-[16px] py-[8px] relative w-full" data-node-id="130:93" data-name="Body">
          <div className="content-stretch flex flex-col gap-[6px] items-center overflow-clip py-[16px] relative shrink-0 w-full" data-node-id="130:94" data-name="Container">
            <div className="bg-[#e6f5ec] content-stretch flex items-center justify-center overflow-clip relative rounded-[36px] shrink-0 size-[72px]" data-node-id="130:95" data-name="Container">
              <div className="relative shrink-0 size-[34px]" data-node-id="130:96" data-name="icon/check">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCheck} />
              </div>
            </div>
            <div className="h-[8px] relative shrink-0 w-px" data-node-id="130:98" data-name="Spacer" />
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] min-w-full relative shrink-0 text-[#18181f] text-[24px] text-center w-[min-content]" data-node-id="130:99">{`You're approved!`}</p>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-full relative shrink-0 text-[#6b6b73] text-[14px] text-center w-[min-content]" data-node-id="130:100">
              Your rider account is now active.
            </p>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[10px] items-start overflow-clip p-[16px] relative rounded-[16px] shrink-0 w-full" data-node-id="130:101" data-name="Account">
            <div className="[word-break:break-word] content-stretch flex gap-[12px] items-center leading-[1.35] overflow-clip relative shrink-0 text-[14px] w-full" data-node-id="130:102" data-name="Row – Rider">
              <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal min-w-px relative text-[#6b6b73]" data-node-id="130:103">
                Rider
              </p>
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] whitespace-nowrap" data-node-id="130:104">
                Juan Dela Cruz
              </p>
            </div>
            <div className="[word-break:break-word] content-stretch flex gap-[12px] items-center leading-[1.35] overflow-clip relative shrink-0 text-[14px] w-full" data-node-id="130:105" data-name="Row – Rider ID">
              <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal min-w-px relative text-[#6b6b73]" data-node-id="130:106">
                Rider ID
              </p>
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] whitespace-nowrap" data-node-id="130:107">
                TX-RDR-8924
              </p>
            </div>
            <div className="content-stretch flex items-center overflow-clip relative shrink-0 w-full" data-node-id="130:108" data-name="Container">
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#6b6b73] text-[14px]" data-node-id="130:109">
                Status
              </p>
              <div className="bg-[#e6f5ec] content-stretch flex items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="130:110" data-name="Chip">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#1e9e5a] text-[12px] whitespace-nowrap" data-node-id="130:111">
                  Active
                </p>
              </div>
            </div>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[12px] items-start overflow-clip p-[16px] relative rounded-[16px] shrink-0 w-full" data-node-id="130:112" data-name="What you can do">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b6b73] text-[13px] w-full" data-node-id="130:113">
              You can now
            </p>
            <div className="content-stretch flex gap-[10px] items-center overflow-clip relative shrink-0 w-full" data-node-id="130:114" data-name="Container">
              <div className="bg-[#e6f5ec] content-stretch flex items-center justify-center overflow-clip relative rounded-[11px] shrink-0 size-[22px]" data-node-id="130:115" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="130:116" data-name="icon/check">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCheck1} />
                </div>
              </div>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#18181f] text-[14px]" data-node-id="130:118">
                Accept nearby Pasugo requests
              </p>
            </div>
            <div className="content-stretch flex gap-[10px] items-center overflow-clip relative shrink-0 w-full" data-node-id="130:119" data-name="Container">
              <div className="bg-[#e6f5ec] content-stretch flex items-center justify-center overflow-clip relative rounded-[11px] shrink-0 size-[22px]" data-node-id="130:120" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="130:121" data-name="icon/check">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCheck1} />
                </div>
              </div>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#18181f] text-[14px]" data-node-id="130:123">
                See live customer routes
              </p>
            </div>
            <div className="content-stretch flex gap-[10px] items-center overflow-clip relative shrink-0 w-full" data-node-id="130:124" data-name="Container">
              <div className="bg-[#e6f5ec] content-stretch flex items-center justify-center overflow-clip relative rounded-[11px] shrink-0 size-[22px]" data-node-id="130:125" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="130:126" data-name="icon/check">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCheck1} />
                </div>
              </div>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#18181f] text-[14px]" data-node-id="130:128">
                Track your earnings
              </p>
            </div>
          </div>
          <div className="flex-[1_0_0] min-h-px relative w-full" data-node-id="130:129" data-name="Flexible space" />
          <a className="bg-[#febc20] content-stretch cursor-pointer flex gap-[8px] items-center justify-center overflow-clip py-[15px] relative rounded-[14px] shrink-0 w-full" data-node-id="130:130" data-name="Button – Set up profile">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="130:131">
              Set up profile
            </p>
            <div className="relative shrink-0 size-[16px]" data-node-id="130:132" data-name="icon/arrow">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconArrow} />
            </div>
          </a>
        </div>
      </div>
    </div>
  );
}
