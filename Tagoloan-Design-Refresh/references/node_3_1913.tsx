const assetPathPrefix = "https://www.figma.com/api/mcp/asset/f1bff5f3-7bb6-4bab-a0c6-848bd4e26a36";
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgIconBack = `${assetPathPrefix}/82c1c.svg`;
const imgIconUser = `${assetPathPrefix}/6f993.svg`;
const imgIconUpload = `${assetPathPrefix}/f3aca.svg`;
const imgIconCamera = `${assetPathPrefix}/78d16.svg`;
const imgIconCheck = `${assetPathPrefix}/a83fa.svg`;
const imgIconArrow = `${assetPathPrefix}/76d20.svg`;

export default function RiderSetupProfile() {
  return (
    <div className="bg-[#fbf9f1] relative size-full" data-node-id="3:1913" data-name="rider setup profile">
      <div className="absolute bg-[#fbf9f1] content-stretch flex flex-col h-[844px] items-start left-0 overflow-clip top-0 w-[390px]" data-node-id="130:136" data-name="Screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="130:137" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="130:138" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="130:139">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="130:140" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="130:141" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="130:143" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="130:145" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex gap-[12px] items-center overflow-clip px-[16px] py-[8px] relative shrink-0 w-full" data-node-id="130:147" data-name="App bar">
          <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex items-center justify-center overflow-clip relative rounded-[20px] shrink-0 size-[40px]" data-node-id="130:148" data-name="Back button">
            <div className="relative shrink-0 size-[18px]" data-node-id="130:149" data-name="icon/back">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBack} />
            </div>
          </a>
          <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="130:151" data-name="Container">
            <p className="font-['Plus_Jakarta_Sans:Bold'] font-bold relative shrink-0 text-[#18181f] text-[18px] w-full" data-node-id="130:152">
              Set up profile
            </p>
            <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="130:153">
              Last step
            </p>
          </div>
        </div>
        <div className="content-stretch flex flex-[1_0_0] flex-col gap-[16px] items-start min-h-px overflow-clip px-[16px] py-[8px] relative w-full" data-node-id="130:155" data-name="Body">
          <div className="content-stretch flex flex-col gap-[6px] items-center overflow-clip py-[16px] relative shrink-0 w-full" data-node-id="130:156" data-name="Container">
            <div className="bg-[#f3f1ea] border border-[#ece8df] border-solid content-stretch flex items-center justify-center overflow-clip relative rounded-[56px] shrink-0 size-[112px]" data-node-id="130:157" data-name="Container">
              <div className="relative shrink-0 size-[44px]" data-node-id="130:158" data-name="icon/user">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconUser} />
              </div>
            </div>
            <div className="h-[10px] relative shrink-0 w-px" data-node-id="130:161" data-name="Spacer" />
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] min-w-full relative shrink-0 text-[#18181f] text-[20px] text-center w-[min-content]" data-node-id="130:162">
              Add a profile photo
            </p>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-full relative shrink-0 text-[#6b6b73] text-[14px] text-center w-[min-content]" data-node-id="130:163">
              Customers use this to recognize you.
            </p>
          </div>
          <div className="content-stretch flex gap-[10px] items-start overflow-clip relative shrink-0 w-full" data-node-id="130:164" data-name="Container">
            <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-[1_0_0] gap-[8px] items-center justify-center min-w-px overflow-clip py-[13px] relative rounded-[14px]" data-node-id="130:165" data-name="Button – Upload">
              <div className="relative shrink-0 size-[16px]" data-node-id="130:166" data-name="icon/upload">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconUpload} />
              </div>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] whitespace-nowrap" data-node-id="130:169">
                Upload
              </p>
            </div>
            <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-[1_0_0] gap-[8px] items-center justify-center min-w-px overflow-clip py-[13px] relative rounded-[14px]" data-node-id="130:170" data-name="Button – Camera">
              <div className="relative shrink-0 size-[16px]" data-node-id="130:171" data-name="icon/camera">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCamera} />
              </div>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] whitespace-nowrap" data-node-id="130:174">
                Camera
              </p>
            </div>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[12px] items-start overflow-clip p-[16px] relative rounded-[16px] shrink-0 w-full" data-node-id="130:175" data-name="Photo tips">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b6b73] text-[13px] w-full" data-node-id="130:176">
              Photo tips
            </p>
            <div className="content-stretch flex gap-[10px] items-center overflow-clip relative shrink-0 w-full" data-node-id="130:177" data-name="Container">
              <div className="bg-[#e6f5ec] content-stretch flex items-center justify-center overflow-clip relative rounded-[11px] shrink-0 size-[22px]" data-node-id="130:178" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="130:179" data-name="icon/check">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCheck} />
                </div>
              </div>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#18181f] text-[14px]" data-node-id="130:181">
                Clear face, no mask or sunglasses
              </p>
            </div>
            <div className="content-stretch flex gap-[10px] items-center overflow-clip relative shrink-0 w-full" data-node-id="130:182" data-name="Container">
              <div className="bg-[#e6f5ec] content-stretch flex items-center justify-center overflow-clip relative rounded-[11px] shrink-0 size-[22px]" data-node-id="130:183" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="130:184" data-name="icon/check">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCheck} />
                </div>
              </div>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#18181f] text-[14px]" data-node-id="130:186">
                Good lighting, plain background
              </p>
            </div>
            <div className="content-stretch flex gap-[10px] items-center overflow-clip relative shrink-0 w-full" data-node-id="130:187" data-name="Container">
              <div className="bg-[#e6f5ec] content-stretch flex items-center justify-center overflow-clip relative rounded-[11px] shrink-0 size-[22px]" data-node-id="130:188" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="130:189" data-name="icon/check">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCheck} />
                </div>
              </div>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#18181f] text-[14px]" data-node-id="130:191">
                Wear a decent shirt
              </p>
            </div>
          </div>
          <div className="flex-[1_0_0] min-h-px relative w-full" data-node-id="130:192" data-name="Flexible space" />
          <a className="bg-[#febc20] content-stretch cursor-pointer flex gap-[8px] items-center justify-center overflow-clip py-[15px] relative rounded-[14px] shrink-0 w-full" data-node-id="130:193" data-name="Button – Save & continue">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="130:194">{`Save & continue`}</p>
            <div className="relative shrink-0 size-[16px]" data-node-id="130:195" data-name="icon/arrow">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconArrow} />
            </div>
          </a>
        </div>
      </div>
    </div>
  );
}
